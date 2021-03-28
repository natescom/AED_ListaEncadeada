package com.nathan;

public class LinkedList {
    private Node head; // Dado que o nó dos elementos apontam um pro outro eu só preciso saber o primeiro nó
    private int size; // Tamanho da lista pra não precisar percorrer todos os nós

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Adiciona objetos ao fim da lista
     * @param data Objeto a ser adicionado
     */
    public void add(Object data){
        if(this.head == null) { // Caso a lista esteja vazia
            this.head = new Node(data); // Eu instancio um nó passando pra ele o meu dado a ser adicionado a lista
        }else{  // Caso a lista não esteja vazia eu tenho que percorrela ate chegar a um no que tenha um next nulo para então adicionar o elemento depois dele
            Node pointer = head; // Variavel auxiliar percorrer a lista
            while(pointer.getNext()!=null){ // Verifica se o proximo elemento é nulo
                pointer = pointer.getNext(); // Se não for então o ponteiro aponta pro proximo
            }  // Se o proximo elemento for nulo significa que cheguei ao meu ultimo elemento da lista
            pointer.setNext(new Node(data)); // O elemento que não apontava para nada agora aponta para o novo nó com o novo elemento que terá o next vazio
        }
        size++; // Aumenta o tamanho da lista em uma unidade
    }

    /**
     * Adiciona objetos ao inicio da lista
     * @param data
     */
    public void addAtBeginning(Object data){
        Node newerNode = new Node(data);    // Instancio um novo nó com o dado que eu quero adicionar
        newerNode.setNext(head); // Coloco o meu novo nó para apontar para a Head atual
        head = newerNode; // Defino meu novo no para ser a nova Head da lista
        size++;
    }

    /**
     * Coloca um dado numa posição qualquer da lista
     * @param index
     * @param data
     */
    public void insert(int index, Object data){
        Node newerNode = new Node(data);    // Instancio um novo nó com o dado que eu quero adicionar
        if(index==0){
            newerNode.setNext(head); // Coloco o meu novo nó para apontar para a Head atual
            head = newerNode; // Defino meu novo no para ser a nova Head da lista
        }else{
            if (index >= size)
                throw new NullPointerException();
            Node anteriorNode = getNode(index-1);
            newerNode.setNext(anteriorNode.getNext());
            anteriorNode.setNext(newerNode);
        }
        size++;
    }

//    /**
//     * Exclui um item da lista
//     * @param index
//     */
//    public void remove(int index){
//        if(size==1){
//            head = null;
//        }else{
//            if(index>=size)
//                throw new NullPointerException();
//            getNode(index-1).setNext(getNode(index+1));
//        }
//        size--;
//    }

    /**
     * Busca Linear
     * @param data Objeto a ser procurado
     * @return Index do objeto na lista
     */
    public int indexOf(Object data) throws ObjetoNaoEncontradoException {
        Node pointer = head;
        int i = 0;
        while(pointer!=null){
            if(pointer.getData()==data)
                return i;
            else
                pointer = pointer.getNext();
            i++;
        }
        throw new ObjetoNaoEncontradoException(data);
    }

    /**
     * Retorna o nó do index passado
     * @param index
     * @return
     */
    private Node getNode(int index){
        Node pointer = head;
        for (int i = 0; i < index; i++) { // Percorrer a lista ate o ponto indicado
            if(pointer==null)
                throw new NullPointerException();
            else
                pointer = pointer.getNext();
        }
        if(pointer==null) // Caso o ultimo pointer.getNext() tenha pego nada, em uma situação de 3 itens na lista o usuario manda o numero 3 mas esquece que começa a contar do 0
            throw new NullPointerException();
        else
            return pointer;
    }

    public Object getData(int index){
        return getNode(index).getData();
    }

    /**
     * Troco o dado no idex passado
     * @param index
     * @param data
     */
    public void setData(int index, Object data){
        Node pointer = head;
        for (int i = 0; i < index; i++) { // Percorrer a lista ate o ponto indicado
            if(pointer==null)
                throw new NullPointerException();
            else
                pointer = pointer.getNext();
        }
        if(pointer==null) // Caso o ultimo pointer.getNext() tenha pego nada, em uma situação de 3 itens na lista o usuario manda o numero 3 mas esquece que começa a contar do 0
            throw new NullPointerException();
        else
            pointer.setData(data);
    }

    public int length(){
        return size;
    }

}
