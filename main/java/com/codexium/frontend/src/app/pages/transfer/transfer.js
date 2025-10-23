import { apiService } from "../../services/api.service.js";

document.getElementById("btnTransferir").addEventListener("click", async () => {
  const origemId = document.getElementById("origemId").value;
  const destinoId = document.getElementById("destinoId").value;
  const quantidade = document.getElementById("quantidade").value;
  const resultado = document.getElementById("resultado");

  try {
    const message = await apiService.transferir(origemId, destinoId, quantidade);
    resultado.textContent = message;
    resultado.style.color = "green";
  } catch (error) {
    resultado.textContent = "Erro: " + error.message;
    resultado.style.color = "red";
  }
});
