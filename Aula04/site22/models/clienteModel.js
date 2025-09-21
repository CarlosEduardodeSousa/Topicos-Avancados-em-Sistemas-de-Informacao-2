const db = require('../db');

module.exports = {
  listar: (callback) => {
    //db.query('SELECT * FROM clientes', callback);
    db.query('SELECT id, nome, endereco, telefone, cpf, email, DATE_FORMAT(data_nascimento, "%d/%m/%Y") AS data_nascimento FROM clientes', callback)
  },  

  buscarPorId: (id, callback) => {
    //db.query('SELECT * FROM clientes WHERE id = ?', [id], callback);
    db.query('SELECT id, nome, endereco, telefone, cpf, email, DATE_FORMAT(data_nascimento, "%d/%m/%Y") AS data_nascimento FROM clientes WHERE id = ?', [id], callback)
  },

  inserir: (cliente, callback) => {
    db.query('INSERT INTO clientes (nome, endereco, telefone, cpf, data_nascimento, email) VALUES (?, ?, ?, ?, ?, ?)', 
      [cliente.nome, cliente.endereco, cliente.telefone, cliente.cpf, cliente.data_nascimento, cliente.email], callback);
  },

   atualizar: (id, cliente, callback) => {
    console.log(cliente);
    db.query('UPDATE clientes SET nome = ?, endereco = ?, telefone = ?, cpf = ?, data_nascimento = ?, email = ? WHERE id = ?', 
     [cliente.nome, cliente.endereco, cliente.telefone, cliente.cpf, cliente.data_nascimento, cliente.email, id], callback);
  },

  excluir: (id, callback) => {
    db.query('DELETE FROM clientes WHERE id = ?', [id], callback);
  },

  verificarNomeExistente: (nome, callback) => {
    db.query('SELECT * FROM clientes WHERE nome = ?', [nome], callback);
  },

    verificarTelefoneExistente: (telefone, callback) => {
    db.query('SELECT * FROM clientes WHERE telefone = ?', [telefone], callback);
  },
  
  buscaNomeTelefone: (nome,telefone,q,callback) =>{
    db.query('SELECT id, nome, endereco, telefone, cpf, email, DATE_FORMAT(data_nascimento, "%d/%m/%Y") AS data_nascimento FROM clientes WHERE nome OR telefone LIKE %?%', [q], callback)
  },

  buscarClientes:(termoBusca, callback) => {
    const query = `
        SELECT * FROM clientes 
        WHERE nome LIKE ? OR telefone LIKE ?
    `;
    const buscaFormatada = `%${termoBusca}%`;

    db.query(query, [buscaFormatada, buscaFormatada], (err, results) => {
        if (err) return callback(err);
        callback(null, results);
    });
}
};
