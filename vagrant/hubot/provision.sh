#!/bin/bash


export DEBIAN_FRONTEND=noninteractive
apt-get -y update


dpkg -s npm &>/dev/null || {

apt-get -y install nodejs npm
#apt-get -y install nodejs npm=1.3.1
#ln -s /usr/bin/nodejs /usr/bin/node
 


}

command -v hubot &>/dev/null || {

npm install -g hubot coffee-script

}