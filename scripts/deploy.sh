#!/bin/bash

# this file is NOT used

REMOTE=play@SERVER_IP
REMOTE_APP=/home/play/PROJECT_NAME/

sbt stage || exit 1;
rsync -va target/ $REMOTE:$REMOTE_APP/target;
ssh $REMOTE "cd $REMOTE_APP; ./stop.sh";
ssh $REMOTE "cd $REMOTE_APP; ./start.sh";
