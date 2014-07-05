#!/bin/sh
pwd

git remote -v

git status

git log

echo my_version > .build_version
cat .build_version

git add .build_version
git config --global.email "travis-ci@travis-ci.org"
git config --global.username "travis-ci"
git commit -m "update .build_version"
git push origin master

echo done
