const API_URL = 'http://localhost:8080/coffees';
const listaCafes = document.getElementById('lista-cafes');
const modal = document.getElementById('modal');
const nomeInput = document.getElementById('nomeCafe');
const idInput = document.getElementById('inputID');
const template = document.getElementById('card-template');

async function buscarCafes() {
    try {
        const res = await axios.get(API_URL);
        mostrarCafes(res.data);
    } catch (error) {
        alert('Erro ao buscar cafés');
    }
}

function mostrarCafes(cafes) {
    listaCafes.innerHTML = '';

    cafes.forEach(cafe => {
        const card = template.content.cloneNode(true);

        card.querySelector('.nome').textContent = cafe.name;
        card.querySelector('.id').textContent = cafe.id.slice(0, 8) + '...';

        const btn = card.querySelector('.delete');
        btn.onclick = () => deletarCafe(cafe.id, cafe.name);

        listaCafes.appendChild(card);
    });
}

async function adicionarCafe() {
    const nome = nomeInput.value.trim();
    if (!nome) {
        alert('Digite um nome para o café');
        return;
    }

    try {
        console.log('Tentando adicionar café:', nome);
        const response = await axios.post(API_URL, { name: nome });
        console.log('Resposta do servidor:', response.data);

        fecharModal();
        nomeInput.value = '';
        buscarCafes();
    } catch (error) {
        console.error('Erro detalhado:', error);

        if (error.response) {
            alert(`Erro ${error.response.status}: ${error.response.data.message || 'Erro no servidor'}`);
        } else if (error.request) {
            alert('Servidor não está respondendo. Verifique se o backend está rodando!');
        } else {
            alert('Erro ao configurar requisição: ' + error.message);
        }
    }
}

async function deletarCafe(id, nome) {
    if (!confirm(`Remover "${nome}"?`)) return;

    try {
        await axios.delete(`${API_URL}/${id}`);
        buscarCafes();
    } catch (error) {
        alert('Erro ao deletar café');
    }
}

function abrirModal() {
    modal.style.display = 'block';
    nomeInput.value = '';
    idInput.value = '';
}

function fecharModal() {
    modal.style.display = 'none';
}

document.getElementById('salvarBtn').onclick = adicionarCafe;

document.addEventListener('keydown', (e) => {
    if (e.key === 'Escape') fecharModal();
});

modal.onclick = (e) => {
    if (e.target === modal) fecharModal();
};

buscarCafes();