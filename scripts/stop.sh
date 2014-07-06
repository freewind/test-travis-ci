#!/bin/bash

pid=../RUNNING_PID

if [[ -f $pid ]]; then
    kill `cat $pid` && sleep 5;
    rm $pid;
    echo "deleted RUNNING_PID"
fi
