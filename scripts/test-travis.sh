#!/bin/sh
pwd

echo my_version > .build_version
cat .build_version

git add .build_version

git remote -v
git status

git config --global user.email "travis-ci@travis-ci.org"
git config --global user.name "travis-ci"
git commit -m "update .build_version"

git --no-pager log --stat

git push origin master

echo done
