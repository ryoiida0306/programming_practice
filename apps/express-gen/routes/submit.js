var express = require('express');
var router = express.Router();

let users = [];

/* GET home page. */
router.get('/', function(req, res, next) {
    const name = req.body.name;
    users.push(name);
    res.json(users);
});
module.exports = router;
