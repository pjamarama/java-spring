#!/usr/bin/env sh

heroku apps:create kolts-shopping-list
heroku addons:create heroku-postgresql:hobby-dev --app kolts-shopping-list