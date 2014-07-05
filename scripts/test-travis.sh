#!/bin/sh
pwd

echo my_version > .build_version
cat .build_version

git add .build_version

git status

git config --global user.email "travis-ci@travis-ci.org"
git config --global user.name "travis-ci"
git commit -m "update .build_version"

git --no-pager log --stat -3

git remote add token https://${GH_TOKEN}@github.com/freewind/test-travis-ci.git
git push token master

git remote -v
git status

echo done
