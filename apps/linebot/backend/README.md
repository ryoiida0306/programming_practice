# 環境構築方法

プロジェクト初期化

```
npm init -y
```

TypeScript 関連のパッケージをインストール

```
npm install -D typescript
npm install -D @types/node
npm install -D ts-node

npx tsc --init
```

express をインストール

```
npm install express
npm install -D @types/express
```

# 実行

```
npx ts-node src/index.ts
```

# 参考

[express 公式ドキュメント](https://expressjs.com/ja/)
