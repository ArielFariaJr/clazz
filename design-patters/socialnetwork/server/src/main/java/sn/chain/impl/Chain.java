package sn.chain.impl;

public abstract class Chain {

	protected Chain next;
    protected IDchain identificadorChain;
 
    public Chain(IDchain id) {
        next = null;
        identificadorChain = id;
    }
 
    public void setNext(Chain forma) {
        if (next == null) {
            next = forma;
        } else {
            next.setNext(forma);
        }
    }	
    
    public void efetuarCheck(IDchain id, String path) throws Exception {
		if (podeEfetuarCheck(id)) {
			efetuarCheck(path);
		} else {
			if (next == null) {
				throw new Exception("Chain does not registered");
			}
			next.efetuarCheck(id, path);
		}
	}

	private boolean podeEfetuarCheck(IDchain id) {
		if (identificadorChain == id) {
			return true;
		}
		return false;
	}

	protected abstract void efetuarCheck(String path);
}
