#!/bin/sh
buildVersion=$1

echo $buildVersion > conf/.build_version

pwd

cat conf/.build_version

