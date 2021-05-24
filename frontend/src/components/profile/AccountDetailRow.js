import React, {useState, useEffect} from 'react'

function ProfileAccountDetailRow(props) {

  const [editFlag, setEditFlag] = useState(false);

  const RenderBasedOnEditable = () => {
    if(props.isEditable){
      return(
        <td><button onClick = {() => {setEditFlag(!editFlag)}}>Edit</button></td>
      )

    }
    else{
      return <td><span> </span></td>
    }
  };

  return (
      <tr>
        <td><span>{props.title}:</span></td>
        {
          editFlag ? (
            <td>
              <input name = "entry" value = {props.entry} placeholder = {props.entry} type = "text" onChange = {e => {props.setEntry(e.target.value)}}/>
            </td>
          ):
          (
            <td><span>{props.entry}</span></td>
          )
        }
        <RenderBasedOnEditable/>
      </tr>
  )
}

export default ProfileAccountDetailRow;
