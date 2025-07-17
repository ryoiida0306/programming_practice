import express, { Request, Response } from 'express';
import bodyParser from 'body-parser';
import axios from 'axios';
import path from 'path';
import { load } from 'ts-dotenv';

const env = load({
    PORT: Number,
})

const app = express();
const PORT = env.PORT | 3000;
const backendUrl = 'http://localhost:3002/users';

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.set('views', path.join(__dirname, '../views'));
app.set('view engine', 'pug');

app.get('/', (req: Request, res: Response) => {
  res.render('index', { title: 'User Management' });
});

type UserInput = {name : String;}

app.post('/users', async (req: Request, res: Response) => {
  const userInput: UserInput = { name: req.body.name };

  try {
    const response = await axios.post(backendUrl, userInput);
    res.send(`User created: ${response.data}`);
  } catch (error) {
    res.status(500).send('Error creating user');
  }
});

app.put('/users/:id', async (req: Request, res: Response) => {
  const userInput: UserInput = { name: req.body.name };

  try {
    const response = await axios.put(`${backendUrl}/${req.params.id}`, userInput);
    res.send(`User updated: ${response.data}`);
  } catch (error) {
    res.status(500).send('Error updating user');
  }
});

app.delete('/users/:id', async (req: Request, res: Response) => {
  try {
    const response = await axios.delete(`${backendUrl}/${req.params.id}`);
    res.send(`User deleted: ${response.data}`);
  } catch (error) {
    res.status(500).send('Error deleting user');
  }
});

app.listen(PORT, () => {
  console.log(`Frontend server is running at http://localhost:${POST}`);
});
