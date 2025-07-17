var express = require('express');
var router = express.Router();

let users = [];

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.post('/submit-form', (req,res,next) =>{
  const name = req.body.name;
  users.push(name);
  res.send(users);
});

module.exports = router;
