db.createUser({user: "honeymon", pwd: "developer", roles: ["root"]})
db.createUser({user: "developer", pwd: "mongodb", roles: ["dbOwner"]})