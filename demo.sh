#!/bin/bash

. third_party/demo-magic/demo-magic.sh

clear

NO_WAIT=true
p "I hear you would like to build a service mesh that includes virtual machines and Kubernetes"
echo
p "Let's take a look at just how easy that is using Consul connect"
echo
p "But first we need a Consul cluster. Thankfully Consul clusters are only a click away when you use HashiCorp Consul Service on Azure"
echo
p "And just like that we have Consul cluster. How about we build a two player version of Pong running on the service mesh??"
echo
p "First let's take a look at the architecture of what we are going to build"
echo
NO_WAIT=false
p "Now that we are familiar with what we need to build let's make that happen"
echo
p "Thankfully you can spin this demo up yourself simply by using terraform apply. Here's one we prepared earlier. Let's play!"
echo
p "Hmmmmm. Why isn't it working. Let's go check if the intentions have been properly applied"
echo
p "Looks like we forgot to apply the intentions via SMI. Let's do that now"
echo

pe "cat terraform/aks/smi/policy.yml"
pe "kubectl create -f terraform/aks/smi/policy.yml"

clear

p "Let's pop back and check the intentions again to verify"
echo
p "Everything looks good. Let's try again"
echo
NO_WAIT=true
p "Wasn't that fun!!!"
echo
p "Thankfully you can run this same demo at home. Check it out here - https://github.com/nicholasjackson/cloud-pong"
echo
p "Massive thanks to Nic Jackson from Hashicorp for building this awesome demo"
echo
p "THE END"
NO_WAIT=false

kubectl delete -f terraform/aks/smi/policy.yml
