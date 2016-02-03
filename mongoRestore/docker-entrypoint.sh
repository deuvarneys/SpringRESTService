#!/bin/bash

#Mongo 3.2 entrypoint.sh modified to accept database dump files to pre-populate database

	
sleep 10
mongorestore -h mongotest:27017 dump

