data "aws_caller_identity" "current" {}
data "aws_region" "current" {}
locals {
  account_id = "${data.aws_caller_identity.current.account_id}"
}
resource "aws_dynamodb_table" "personal-finance-user" {
  name = "user"
  read_capacity = "10"
  write_capacity = "10"
  hash_key = "user_id"
  range_key = "creation_date"

  attribute {
    name = "user_id"
    type = "S"
  }

  attribute {
    name = "creation_date"
    type = "S"
  }
}
resource "aws_dynamodb_table" "personal-finance-account" {
  name = "account"
  read_capacity = "10"
  write_capacity = "10"
  hash_key = "account_id"

  attribute {
    name = "account_id"
    type = "S"
  }
}