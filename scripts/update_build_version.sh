#!/bin/sh
if [ "$TRAVIS_PULL_REQUEST" == "false" ]; then
  echo -e "Starting to update .build_version file\n"

  #go to home and setup git
  cd $HOME
  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "Travis"

  git remote add token https://${GH_TOKEN}@github.com/freewind/test-travis-ci.git

  git add -f .
  git commit -m "Travis update .build_version file to $TRAVIS_BUILD_NUMBER"
  git push -fq token master > /dev/null

  echo -e "Build version updated to $TRAVIS_BUILD_NUMBER\n"
fi
