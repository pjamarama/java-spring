#!/usr/bin/env sh

heroku apps:create alexey-traffic-app
heroku addons:create heroku-postgresql:hobby-dev --app alexey-traffic-app