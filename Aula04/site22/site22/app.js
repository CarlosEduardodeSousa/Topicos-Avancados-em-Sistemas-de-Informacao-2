const express = require('express');
const bodyParser = require('body-parser');
const clienteRoutes = require('./routes/clienteRoutes');

const app = express();
app.set('view engine', 'ejs');
app.use(bodyParser.urlencoded({ extended: true }));
app.use(clienteRoutes);

app.listen(3333, () => {
  console.log('Servidor rodando em http://localhost:3000');
});
