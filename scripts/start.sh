#!/bin/bash
nohup ./bin/test-travis-ci -Dhttp.port=9090 &> logs/nohup.log
# You can provide all the -Dsettings you need to set for your application here :-)
