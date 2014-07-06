#!/bin/sh
echo TRAVIS_PULL_REQUEST: $TRAVIS_PULL_REQUEST

if [ "$TRAVIS_PULL_REQUEST" = "false" ]; then

    echo -e "Starting to update build_version file"

    pwd

    git checkout master

    echo $TRAVIS_BUILD_NUMBER > build_version
    cat build_version

    git add -f build_version

    git status

    git config --global user.email "travis-ci@travis-ci.org"
    git config --global user.name "travis-ci"
    git commit -m "update build_version to $TRAVIS_BUILD_NUMBER"

    git --no-pager log --stat -3

    git remote add token https://${GH_TOKEN}@github.com/freewind/test-travis-ci.git
    git push -fq token master

    git status

    echo -e "done updating build_version"

fi
