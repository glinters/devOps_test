terraform {
  required_providers {
    # Izvēlas provider - DevOps mācībām ir AWS, provider versija 5.3.0
    aws = {
      source = "hashicorp/aws"
      version = "5.3.0"
    }
  }
  # Terraform versija
  required_version = ">= 1.5.0"
}

# Konfigurē provider
provider "aws" {
    region = "us-west-1"
}

resource "aws_instance" "GroupD_server" {
  ami           = "ami-0f8e81a3da6e2510a"
  instance_type = "t2.micro"

  tags = {
    Name = "GroupD_server"
    Owner = "Davis"
    CoOwner = "Gatis"
    Team = "D"
  }
}

# papildināt ar:
# storage
# network