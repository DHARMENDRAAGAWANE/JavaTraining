ansible-galaxy install -r .applier/requirements.yml --roles-path=galaxy
ansible-playbook -i .applier/inventory-sbx/ galaxy/openshift-applier/playbooks/openshift-cluster-seed.yml -e filter_tags=sbx