data "aws_caller_identity" "current" {}
data "aws_region" "current" {}
locals {
  account_id = "${data.aws_caller_identity.current.account_id}"
}
resource "aws_dynamodb_table" "account-service-user" {
  name = "user"
  read_capacity = "10"
  write_capacity = "10"
  hash_key = "user_id"

  attribute {
    name = "user_id"
    type = "S"
  }
}