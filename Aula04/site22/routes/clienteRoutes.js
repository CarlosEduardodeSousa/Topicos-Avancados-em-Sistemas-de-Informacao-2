const express = require('express');
const router = express.Router();
const controller = require('../controllers/clienteController');

router.get('/', controller.listar);
router.get('/novo', controller.formNovo);
router.post('/novo', controller.inserir);
router.get('/editar/:id', controller.editar);
router.post('/editar/:id', controller.atualizar);
router.get('/excluir/:id', controller.excluir);
router.get('/detalhes/:id', controller.detalhes);

module.exports = router;
