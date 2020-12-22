#!/bin/bash

function x_type()
{
	xdotool type -- "$1"
	xdotool key "Return"
	sleep 0.2
}

function change_keyboard_layout
{
  previous_layout=$(setxkbmap -query | grep -e "layout" |cut -d " " -f 6)
	setxkbmap fr
}

function restore_keyboard_layout()
{
	setxkbmap $previous_layout
}

function make_the_game()
{
	make release
	sleep 3
}

function run_the_game()
{
	mkdir -p result
	sleep 0.2
	xdotool type "java -jar "$1
	xdotool key shift+94
	xdotool type "result/result_""$2"".txt"
	xdotool key "Return"
	sleep 2
}

function launch_new_term()
{
	xterm  &
	PIDXterm=$!
	sleep 0.5
	WIDXterm=$(wmctrl -lp | grep -e $PIDXterm | cut -d " " -f 1)
	xdotool windowactivate $WIDXterm
	sleep 0.5
}

function get_scenarios()
{
	list_scenarios=$(ls test_scenarios | grep -e .sc)
}

function close_terminal()
{
	kill -9 $PIDXterm
}

function check_game_run()
{
	check_line=$(ps -al | grep -e "java")
	if [ -z "$check_line" ]
	then
		return 0
	else
		return 1
	fi
}

function generate_test_log()
{
	change_keyboard_layout
	get_scenarios
	for scenario in $list_scenarios
	do
		echo $scenario
		launch_new_term
		run_the_game $1 $scenario
		check_game_run
		if [[ $? == 0 ]]
		then
			echo "Cannot launch java application"
			close_terminal
			return
		fi

		while read line
		do
			x_type "$line"
		done<"test_scenarios/"$scenario
		sleep 0.2

		check_game_run
		if [[ $? == 1 ]]
		then
			echo "Game has not quit after scenario"
		fi

		close_terminal

		cp "log.txt" "result/log_"$scenario".txt"

		echo

	done

	restore_keyboard_layout
}


function generate_regex_from_line()
{
	regex=""
	local i=0
	while [[ $i -lt ${#1} ]]
	do
		character[$i]=${1:$i:1}
		if [[ ${character[$i]} =~ [[:blank:]] ]]
		then
			regex=$regex"[[:blank:]]*"
		elif [[ ${character[$i]} =~ [[:digit:]] ]]
		then
			regex=$regex"["${character[$i]}"]"
		elif [[ ${character[$i]} =~ [[:punct:]] ]]
		then
			regex=$regex$"["${character[$i]}"]"
		elif [[ ${character[$i]} =~ [[:alpha:]] ]]
		then
			regex=$regex"["${character[$i]^}${character[$i],}"]"
		fi
		let "i=i+1"
	done
}


function check_file()
{
	local i=0
	while read line
	do
		generate_regex_from_line "$line"
		if [[ $regex != "" ]]
		then
			list_regex[$i]=$regex
			list_expected_line[$i]=$line
			let "i=i+1"
		fi
	done<"expected_result/"$2"_"$1".txt"

	local j=0
	while read line
	do
		if [[ $line =~ ${list_regex[$j]} ]]
		then
			let "j=j+1"
		fi
	done<"result/"$2"_"$1".txt"

	desc=$2

	if [[ $j == $i ]]
	then
		echo "test "$1" "$desc" is ok".
	else
		echo "test "$1" "$desc" has failed starting at line:"$j
		echo "line: \""${list_expected_line[$j]}"\" has not been found"
	fi
}

function check_result()
{
	check_file "$1" "result"
}

function check_log()
{
	check_file "$1" "log"
}

function check_test_log
{
	get_scenarios
	for scenario in $list_scenarios
	do
		check_result $scenario
		check_log $scenario
		echo
	done
}

function run_tests
{
	generate_test_log $1
	check_test_log>result_test.txt
}

run_tests $1
