import React,{Component} from "react";
import { storage,auth } from "../firebase";

class SignIn extends Component {
    constructor(props) {
        super(props);
        this.state = {  
            emailId:null,
            password: null
        };
    }

    login=()=>{
        // localStorage.setItem("users","admin");
        // window.location.reload();
        auth.signInWithEmailAndPassword(this.state.emailId, this.state.password)
            .then((userCredential) => {
                // Signed in 
                var user = userCredential.user;
                // ...
            })
            .catch((error) => {
                var errorCode = error.code;
                var errorMessage = error.message;
            });
    }
    
    render() { 
        return ( 
            <div>
                <input className='loginpage_text' type='text' onChange={(event)=>{this.state.emailId=event.currentTarget.value;}} placeholder='Phone number, username, or email'/>
                <input className='loginpage_text' type='password' onChange={(event)=>{this.state.password=event.currentTarget.value;}} placeholder='Password'/>
                <button className='login_btn' onClick={this.login}>Log In</button>
            </div>
        );
    }
}
 
export default SignIn;