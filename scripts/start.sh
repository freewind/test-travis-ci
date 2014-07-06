#!/bin/bash
mkdir -p logs
nohup ./bin/test-travis-ci -Dhttp.port=9090 >/dev/null 2>&1 &
# You can provide all the -Dsettings you need to set for your application here :-)
