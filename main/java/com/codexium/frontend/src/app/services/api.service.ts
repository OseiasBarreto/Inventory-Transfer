class ApiService {
  constructor(baseUrl) {
    this.baseUrl = baseUrl;
  }

  async transferir(origemId, destinoId, quantidade) {
    const url = `${this.baseUrl}/api/transfer?origemId=${origemId}&destinoId=${destinoId}&quantidade=${quantidade}`;
    const response = await fetch(url, { method: "POST" });
    if (!response.ok) {
      const error = await response.text();
      throw new Error(error);
    }
    return await response.text();
  }

  async listarWarehouses() {
    const response = await fetch(`${this.baseUrl}/api/warehouses`);
    return await response.json();
  }

  async listarStocks() {
    const response = await fetch(`${this.baseUrl}/api/stocks`);
    return await response.json();
  }
}

export const apiService = new ApiService("http://localhost:8080");
