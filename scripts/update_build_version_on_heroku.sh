#!/bin/sh
buildVersion=$1

echo $buildVersion > conf/.build_version

cat conf/.build_version

echo "========== " `pwd` "=========="
ls -al

echo "========== " `pwd`/conf/ "========="
ls -al /conf/

