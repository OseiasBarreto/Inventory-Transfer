document.getElementById("transferForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const origemId = document.getElementById("origemId").value;
  const destinoId = document.getElementById("destinoId").value;
  const quantidade = document.getElementById("quantidade").value;

  const mensagem = document.getElementById("mensagem");

  try {
    const response = await fetch(`http://localhost:8080/api/transfer?origemId=${origemId}&destinoId=${destinoId}&quantidade=${quantidade}`, {
      method: "POST"
    });

    const data = await response.text();
    mensagem.textContent = data;
    mensagem.style.color = response.ok ? "green" : "red";

  } catch (error) {
    mensagem.textContent = "Erro ao conectar com o servidor!";
    mensagem.style.color = "red";
  }
});
