import express from "express";
import {load} from 'ts-dotenv';

const app = express();

app.use(express.json());

const env = load({
  PORT: Number
})

const PORT = env.PORT || 3000;

app.listen(PORT, () => {
  console.log(`Start on port ${PORT}.`);
});

type User = {
  id: number;
  name: string;
  email: string;
};

const users: User[] = [
  { id: 1, name: "User1", email: "user1@test.local" },
  { id: 2, name: "User2", email: "user2@test.local" },
  { id: 3, name: "User3", email: "user3@test.local" },
];

//一覧取得
app.get("/users", (req: express.Request, res: express.Response) => {
  res.json(users);
});

// app.get("/", (req: express.Request, res: express.Response) => {
//   res.status(200).json({message : "Hello world!!!!"});
// });

app.get("/", (req: express.Request, res: express.Response) => {
  res.status(200).
});





