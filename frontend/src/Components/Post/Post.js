import React,{Component} from "react";
import './Post.css'
import { Avatar } from "@mui/material";
import postImage from "../../images/post2.jpg";
import love from "../../images/love.png";
import comments from "../../images/comments.png";
import send from "../../images/send.png";


class Post extends Component {
    constructor(props) {
        super(props);
        this.state = {  
            commentList:[]
        }
    }

    componentDidMount(){
        this.getComments();
    }

    getComments=()=>{
        let data =[
            {
                "username": "aravind",
                "commentId": "1234",
                "timeStamp": "123456",
                "description": "Comment 1"
            },
            {
                "username": "keeru",
                "commentId": "1234",
                "timeStamp": "123456",
                "description": "Comment 2"
            },
            {
                "username": "arun",
                "commentId": "1234",
                "timeStamp": "123456",
                "description": "Comment 3"
            }
        ];
        this.setState({commentList: data});
    }

    render() { 
        return (  
            <div className="post_container">
                {/* Header */}
                <div className="post_header">
                    <Avatar className="post_image" src={this.props.profileImage}/>
                    <div className="post_username">{this.props.username}</div>
                </div>

                {/* Image */}
                <div>
                    <img src={this.props.postImage} width="615px"/>
                </div>

                {/* Analytics */}
                <div>
                    <div style={{marginLeft:"10px"}}>
                        <img src={love} className="post_reactImage"/>
                        <img src={comments} className="post_reactImage"/>
                        <img src={send} className="post_reactImage"/>
                    </div>
                    <div style={{fontWeight:"bold", marginLeft:"20px"}}>
                        {this.props.likes} likes
                    </div>
                </div>

                {/* Comment section */}
                <div>
                    {
                        this.state.commentList.map((item,index)=>(
                            <div className="post_comment">{item.username}: {item.description}</div>
                        ))
                    }
                    <input className="post_commentBox" type="text" placeholder="Add a comment..." />
                </div>
            </div>
        );
    }
}
 
export default Post;