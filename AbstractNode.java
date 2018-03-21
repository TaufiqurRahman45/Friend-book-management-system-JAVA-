/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbst;

/**
 *
 * @author AVRO
 */
public abstract class AbstractNode<E> implements TreeNode<E> {
  @Override /**  traversal from the root*/
  public void inorder() {
  }

  @Override /** Postorder traversal from the root */
  public void postorder() {
  }

  @Override /**  traversal from the root */
  public void preorder() {
  }

   /** Return true if the tree is empty */
  public boolean isEmpty() {
    return getSize() == 0;
  }
}