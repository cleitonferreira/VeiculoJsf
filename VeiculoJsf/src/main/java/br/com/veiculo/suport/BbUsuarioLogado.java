package br.com.veiculo.suport;

import br.com.veiculo.model.entities.Usuario;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean(name = "bbUsuarioLogado")
@SessionScoped
public class BbUsuarioLogado implements Serializable {

    private static final long serialVersionUID = 1L;
    private String usu_email;
    SecurityContext context = SecurityContextHolder.getContext();

    public BbUsuarioLogado() {
    }

    //PODEMOS DEIXAR NOSSO BACKING BEAN MAIS ENXUTO USANDO APENAS O TRECHO DE CÓDIGO ABAIXO
    public Usuario procuraUsuario() {
        if (context instanceof SecurityContext) {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                usu_email = (((User) authentication.getPrincipal()).getUsername());
            }
        }
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery("from Usuario user where user.usu_email like ?");
        query.setString(0, usu_email);
        return (Usuario) query.uniqueResult();
    }
    
    
}
