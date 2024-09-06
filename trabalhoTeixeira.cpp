// MYLENA ANTONELLI, IGOR XISTO, VICTOR MIRANDA


#include <iostream>
#include <vector>
#include <string>
#include <cstdlib> // Para std::abs

using namespace std;

#define HASH_TABLE_SIZE 7

typedef struct {
    int cont;
    vector<string> key;
} elemento;

// Estrutura da tabela de hash
typedef struct {
    vector<elemento> table[HASH_TABLE_SIZE];
} HashTable;

// Função hash para calcular a posição na tabela

// Função hash DJB2
unsigned long djb2_hash(const string& str) {
    unsigned long hash = 5381;
    for (char c : str) {
        hash = ((hash << 5) + hash) + static_cast<unsigned char>(c); // hash * 33 + c
    }
    return hash;
}
int hashKey(const string& key) {
    unsigned long keyHash = djb2_hash(key);
    return abs(static_cast<int>(keyHash % HASH_TABLE_SIZE));
}


// Função para buscar um elemento na tabela
bool hashSearch(const HashTable* hash, const string& key) {
    int pos = hashKey(key);
    for (const auto& elem : hash->table[pos]) {
        for (const auto& k : elem.key) {
            if (k == key) {
                return true;
            }
        }
    }
    return false;
}

// Função para inserir um elemento na tabela
void hashInsert(HashTable* hash, const string& key) {
    int pos = hashKey(key);
    for (auto& elem : hash->table[pos]) {
        for (auto& k : elem.key) {
            if (k == key) {
                elem.cont++; // Incrementa o contador
                cout << "pos: " << pos << ", key: " << key << ", count: " << elem.cont << endl;
                return;
            }
        }
    }
    // Se a chave não for encontrada, adiciona nova entrada
    elemento newElem;
    newElem.cont = 1;
    newElem.key.push_back(key);
    hash->table[pos].push_back(newElem);
    cout << "pos: " << pos << ", key: " << key << ", count: 1" << endl;
}

// Função para deletar um elemento da tabela
void hashDelete(HashTable* hash, const string& key) {
    int pos = hashKey(key);
    auto& bucket = hash->table[pos];
    for (auto it = bucket.begin(); it != bucket.end(); ++it) {
        for (auto kIt = it->key.begin(); kIt != it->key.end(); ++kIt) {
            if (*kIt == key) {
                if (it->cont > 1) {
                    it->cont--; // Decrementa o contador se maior que 1
                    kIt = it->key.erase(kIt); // Remove a chave da lista
                    cout << "key: " << key << " count decremented to " << it->cont << endl;
                } else {
                    it->key.erase(kIt); // Remove a chave da lista
                    if (it->key.empty()) {
                        bucket.erase(it); // Remove o elemento se a lista de chaves estiver vazia
                    }
                    cout << "key: " << key << " removed from table" << endl;
                }
                return;
            }
        }
    }
}

/*void ordenaMap(HashTable* hash){
    int maior = 0;
    int contElemento = 0;
    elemento element;
    for(int i = 0; i < 7; i++){
        contElemento = 0;
        for(auto& elem : hash->table[i]){
            if(elem.cont > maior){
                maior = elem.cont;
                element = hash->table[i][contElemento];
            }
            contElemento++;
           
        }
    }
    cout << "Elemento:"<<element.key[0]<<","<<maior<< endl; TENTATIVA DE ORDENAR, DEU MTO CERTO NÃO, VE E CORRIGE AI PRA NOIXX!! ATT: IGONA
    hashDelete(hash,element.key[0]);
    ordenaMap(hash);
}*/

int main() {
    HashTable table;

    // Inicializando a tabela de hash
    for (int i = 0; i < HASH_TABLE_SIZE; ++i) {
        table.table[i] = vector<elemento>();
    }

    // Inserindo valores
    hashInsert(&table, "mel");
    hashInsert(&table, "mel");
    hashInsert(&table, "mel");
    hashInsert(&table, "ovo");
    hashInsert(&table, "maca");
    hashInsert(&table, "abobora"); // Inserção adicional para testar contagem

    // Deletando um valor
    hashDelete(&table, "a");

    // Verificando se o valor foi removido ou seu contador foi ajustado
    cout << "key 'a' encontrada " << (hashSearch(&table, "a") ? "sim" : "não") << endl;
    HashTable table2 = table;
    
    ordenaMap(&table2);
    
    return 0;
}
