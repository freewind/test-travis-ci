#!/bin/sh
buildVersion=$1

echo $buildVersion > conf/.build_version

cat conf/.build_version
