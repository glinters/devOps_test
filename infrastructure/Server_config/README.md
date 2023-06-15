# Servera konfigurācijas info

Šeit ir pieejama Terraform konfigurācija projekta servera izveidošanai iekš AWS.

## Izmantošana

1) Uz palaišanas datora jābūt uzinstalētam Terraform, kā arī AWS cli un jāiekonfigurē atslēga, lai tiktu pie AWS.
2) Jānoklonē git repo
3) Jāatver powershell repo klona mapē
4) izpilda komandu 'terraform init'
5) pārbauda konfigurāciju ar 'terraform plan'
6) izveido serveri ar 'terraform apply'


## AWS parametri

Region: us-west-1
Ubuntu 22.04 LTS OS: ami-0f8e81a3da6e2510a
Servera tips: t2.micro
Storage: 20G
Network: 