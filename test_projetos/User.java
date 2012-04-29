package ufcg.edu.br.Sistema120121.sistema;

import java.util.ArrayList;
import java.util.List;

import ufcg.edu.br.Sistema120121.excecoes.AdressErrorException;
import ufcg.edu.br.Sistema120121.excecoes.EmailErrorException;
import ufcg.edu.br.Sistema120121.excecoes.LoginErrorException;
import ufcg.edu.br.Sistema120121.excecoes.NameErrorException;
import ufcg.edu.br.Sistema120121.excecoes.PasswordErrorException;
import ufcg.edu.br.Sistema120121.excecoes.PhoneErrorException;

public class User{
	 
	private String login;
	private String endereco;
	private String email;
	private String telefone;
	private String nome;
	private String senha;
	private List<User> listaDeAmigos = new ArrayList<User>();

	public User(String login,String senha,String nome,String endereco,String email,String telefone) throws AdressErrorException, EmailErrorException, PasswordErrorException, NameErrorException, PhoneErrorException, LoginErrorException{
		if (email == null || email.isEmpty()){
			throw new EmailErrorException("Email inválido");
		}
		
		if (nome == null || nome.isEmpty()){
			throw new NameErrorException("Nome inválido");
		}
		
		if (login == null || senha == null || senha.isEmpty() || login.isEmpty() || login.length() < 3){
			throw new LoginErrorException("Login inválido");
		}

		this.login = login;
		setSenha(senha); 
		setNome(nome);
		setEndereco(endereco);
		setEmail(email);
		setTelefone(telefone);
	}
	
	public String getPerfil() throws AdressErrorException, EmailErrorException, PasswordErrorException, NameErrorException, PhoneErrorException, LoginErrorException{
		return new Perfil(new User(login, senha, nome, endereco, email, telefone)).exibeMeuPerfil();
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) throws AdressErrorException{
		if (endereco.isEmpty() || endereco.matches("[0-9]*")) throw new AdressErrorException("Endereço inválido");
		else this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailErrorException{
		if (email.matches("[\\w_.]+@\\w+[..](com|com[.-.]br)")) {
			this.email = email;
		}	else{
			throw new EmailErrorException("Email inválido");
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws PhoneErrorException{
		if (!(telefone.matches("[0-9]*")) || telefone.isEmpty() || telefone.length() < 8) throw new PhoneErrorException("Fone Invalido");
		else this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NameErrorException{
		if (!(nome == null) && (nome.matches("[A-Za-z�-�\\s]*+") && nome.length() >= 3) && (!(nome.isEmpty()))) this.nome = nome;
		else throw new NameErrorException("Nome inv�lido");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws PasswordErrorException{
		if (senha.isEmpty() || senha.length() < 4) throw new PasswordErrorException("Senha inválida");
		else this.senha = senha;
	}

	public String getLogin() {
		return login;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User)){
			return false;
		}
		User user1 = (User) obj;
		return (this.getLogin().equals(user1.getLogin()) || this.getEmail().equals(user1.getEmail()));
	}	


	public List<User> getListaAmigos(){
		return listaDeAmigos;
	}
	
	
	public boolean ehAmigo(User usuario){
		return (listaDeAmigos.contains(usuario));
	}

	public void addAmigo(User usuario){
		if (!(this.equals(usuario))) listaDeAmigos.add(usuario);
	}
	
	


}

	
	
	


