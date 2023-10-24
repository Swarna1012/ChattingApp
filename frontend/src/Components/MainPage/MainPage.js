import React,{Component} from "react";
import './MainPage.css'
import Post from "../Post/Post";
import post from "../../images/post1.jpg";

class MainPage extends Component {
    constructor(props) {
        super(props);
        this.state = {  
            postArray:[]
        }
    }
    
    componentDidMount(){
        this.getPost();
    }
    getPost=()=>{
        let data =[
            {
                "postId": "123456",
                "username": "swarna",
                "postImageURL": "https://w0.peakpx.com/wallpaper/917/343/HD-wallpaper-nature-night.jpg",
                "timeStamp": "111111",
                "likes": "7989"
            },
            {
                "postId": "123456",
                "username": "arun",
                "postImageURL": "https://w0.peakpx.com/wallpaper/917/343/HD-wallpaper-nature-night.jpg",
                "timeStamp": "111111",
                "likes": "7989"
            },
            {
                "postId": "123456",
                "username": "anu",
                "postImageURL": "https://w0.peakpx.com/wallpaper/917/343/HD-wallpaper-nature-night.jpg",
                "timeStamp": "111111",
                "likes": "7989"
            }
        ];
        this.setState({postArray: data});
    }
    render() { 
        return (  
            <div>
                {
                    this.state.postArray.map((item,index)=>(
                        <Post id={item.postId} username={item.username} postImage={item.postImageURL} likes={item.likes} />
                    ))
                }
            </div>
        );
    }
}
 
export default MainPage;