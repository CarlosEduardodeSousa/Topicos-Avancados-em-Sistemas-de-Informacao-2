const express = require('express');
const cors = requise ('cors');
const mysql = require ('mysql');

const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

// Configuração do bando de dados MySQL
const pool= mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'mercado',
    waitForConnections: true,
    connectionLimit: 10,
    queueLimit: 0,
});

app.route('/pedido')

    .post(function(req, res){
        const item = req.body.item;
        const quantidade = req.body.quantidade;

        if(!item || !quantidade){
            return res.status(400).json({ erro: 'precisa enviar item e quantidade'});
        }

        pool.query(
            'INSERT INTO pedidos (item, quantidade) VALUES (?, ?)',
            [item, quantidade],
            function (err, results){
                if(err){
                    console.error(err)
                    return res.status(500).json({ erro: 'erro ao adicionar item'});
                }
                res.status(201).json({mensagem: 'Item adicionado'});
            }
        );
    })

    app.get(function(req, res){
        pool.query('SELECT * FROM pedidos', function (err,results){
            if(err){
                console.error(err);
                res.status(500).json({ erro: 'Erro ao buscar pedidos'});
            }
            
            if(results.length === 0){
                return res.status(200).json({ mensagem: 'Pedido vazio'});
            }

            res.json(results);
        });
    });

    // Rota para excluir um item do pedido
    app.delete('/pedido/:id', function (req, res){
        const id = req.params.id;

        pool.query('DELETE FROM pedidos WHERE id = ?', [id], function (err, results){
            if(err){
                console.error(err);
                return res.status(500).json({ erro: 'Erro ao excluir item'});
            }

            if(results.affectedRows === 0){
                return res.status(404).json({ erro: 'Item não encontrado'});
            }

            res.json({ mensagem: 'Item excluido'});
        });
    });

    //Rota para alterar o pedido
    app.put('/pedido/:id', function(req, res){
        const id = req.body.id;
        const novoItem = req.body.item;
        const novaQuantidade = req.body.quantidade;

        if(!novoItem || !novaQuantidade){
            return res.status(400).json({ erro: 'precisa enviar novo item e quantidade'});
        }

        pool.query(
            'UPDATE pedidos SET item = ?, quantidade = ?, WHERE id = ?',
            [novoItem, novaQuantidade, id],
            function (err, results){
                if(err){
                    console.error(err);
                    return res.status(500)
                }

                if(results.affectedRows === 0){
                    return res.status(404).json({ erro: 'Item não encontrado'});
                }

                res.json({ mensagem: 'item alterado'});
            }
        );
    });

    //Inicia o servidor

    app.listen(port, function(){
        console.log(`Servidor rodando em http://localhost:${port}`);
    });
