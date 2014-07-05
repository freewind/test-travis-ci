#!/bin/sh
buildVersion = $1

echo -e "build version: $buildVersion"

echo $buildVersion > conf/.build_version

cat conf/.build_version
