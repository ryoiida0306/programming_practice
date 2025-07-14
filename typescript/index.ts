import express from "express"

const app = express();

app.use(express.json())

app.listen(3000, () => console.log("Start on port 3000."));

type User = {
    id: number;
    name: string;
    age: number;
}

const users: User[] = [
    {id: 1, name: "iida.ryo", age: 22}
]

app.get("/users", (req: express.Request, res: express.Response) => {
    res.json(users);
})

app.get("/users/:id", (req: express.Request, res: express.Response) => {
    const id = Number(req.params.id);
    const user = users.find((user) => user.id === id);
    if(user) {
        res.json(user);
    }else {
        res.status(404).json({message: "User not found."});
    }
})
