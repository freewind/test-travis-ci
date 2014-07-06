#!/bin/bash
nohup ./target/universal/stage/bin/test-travis-ci -Dhttp.port=9090 &
# You can provide all the -Dsettings you need to set for your application here :-)
