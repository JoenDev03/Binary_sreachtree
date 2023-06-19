import java.util.Scanner;

class Node {
  int data;
  Node left, right;

  public Node(int item) {
    data = item;
    left = right = null;
  }
}

class BinarySearchTree {
  Node root;

  BinarySearchTree() {
    root = null;
  }

  void insert(int key) {
    root = insertRec(root, key);
  }

  Node insertRec(Node root, int key) {
    if (root == null) {
      root = new Node(key);
      return root;
    }

    if (key < root.data) {
      root.left = insertRec(root.left, key);
    } else if (key > root.data) {
      root.right = insertRec(root.right, key);
    }

    return root;
  }

  Node search(Node root, int key) {
    if (root == null || root.data == key) {
      return root;
    }

    if (key < root.data) {
      return search(root.left, key);
    }

    return search(root.right, key);
  }

  Node findSmallestNode(Node root) {
    if (root == null || root.left == null) {
      return root;
    }

    return findSmallestNode(root.left);
  }

  Node findLargestNode(Node root) {
    if (root == null || root.right == null) {
      return root;
    }

    return findLargestNode(root.right);
  }

  void delete(int key) {
    root = deleteRec(root, key);
  }

  Node deleteRec(Node root, int key) {
    if (root == null) {
      return root;
    }

    if (key < root.data) {
      root.left = deleteRec(root.left, key);
    } else if (key > root.data) {
      root.right = deleteRec(root.right, key);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      root.data = findSmallestNode(root.right).data;
      root.right = deleteRec(root.right, root.data);
    }

    return root;
  }

  void printInOrder(Node node) {
    if (node != null) {
      printInOrder(node.left);
      System.out.print(node.data + " ");
      printInOrder(node.right);
    }
  }

  void printPreOrder(Node node) {
    if (node != null) {
      System.out.print(node.data + " ");
      printPreOrder(node.left);
      printPreOrder(node.right);
    }
  }

  void printPostOrder(Node node) {
    if (node != null) {
      printPostOrder(node.left);
      printPostOrder(node.right);
      System.out.print(node.data + " ");
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BinarySearchTree bst = new BinarySearchTree();

    int choice;
    do {
      System.out.println("Operasi Pohon Pencarian Biner:");
      System.out.println("1. Masukkan data");
      System.out.println("2. Hapus data");
      System.out.println("3. Cetak In Order");
      System.out.println("4. Cetak Pre Order");
      System.out.println("5. Cetak Post Order");
      System.out.println("6. Temukan Node Terkecil");
      System.out.println("7. Temukan Node Terbesar");
      System.out.println("8. Keluar");
      System.out.print("Masukkan pilihan Anda: ");
      choice = scanner.nextInt();

        switch (choice) {
    case 1:
      System.out.print("Masukkan nilai yang akan dimasukkan: ");
      int insertValue = scanner.nextInt();
      bst.insert(insertValue);
      System.out.println("Data berhasil dimasukkan!");
      break;
    case 2:
      System.out.print("Masukkan nilai yang akan dihapus: ");
      int deleteValue = scanner.nextInt();
      Node deletedNode = bst.search(bst.root, deleteValue);
      if (deletedNode != null) {
        bst.delete(deleteValue);
        System.out.println("Data berhasil dihapus!");
      } else {
        System.out.println("Data tidak ditemukan!");
      }
      break;
    case 3:
      System.out.println("Traversal In Order:");
      bst.printInOrder(bst.root);
      System.out.println();
      break;
    case 4:
      System.out.println("Traversal Pre Order:");
      bst.printPreOrder(bst.root);
      System.out.println();
      break;
    case 5:
      System.out.println("Traversal Post Order:");
      bst.printPostOrder(bst.root);
      System.out.println();
      break;
    case 6:
      Node smallestNode = bst.findSmallestNode(bst.root);
      if (smallestNode != null) {
        System.out.println("Node Terkecil: " + smallestNode.data);
      } else {
        System.out.println("Pohon kosong!");
      }
      break;
    case 7:
      Node largestNode = bst.findLargestNode(bst.root);
      if (largestNode != null) {
        System.out.println("Node Terbesar: " + largestNode.data);
      } else {
        System.out.println("Pohon kosong!");
      }
      break;
    case 8:
      System.out.println("Keluar...");
      break;
    default:
      System.out.println("Pilihan tidak valid. Silakan coba lagi.");
      break;
  }
  System.out.println();
} while (choice != 8);

scanner.close();

  }
}

