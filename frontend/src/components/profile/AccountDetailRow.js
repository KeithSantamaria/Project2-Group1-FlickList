import React, { useState, useEffect } from 'react'

function ProfileAccountDetailRow(props) {

  const [editFlag, setEditFlag] = useState(false);

  const RenderBasedOnEditable = () => {
    if (props.isEditable) {
      return (
        <td><button className="focus:outline-none hover:text-primary font-semibold opacity-70"
          onClick={() => { setEditFlag(!editFlag) }}>Edit</button></td>
      )

    }
    else {
      return <td><span> </span></td>
    }
  };

  return (
    <tr>
      <td><span>{props.title}:</span></td>
      {
        editFlag ? (
          <td>
            <input className="bg-gray-100 rounded-full px-2" name="entry" value={props.entry} placeholder={props.entry} type="text" onChange={e => { props.setEntry(e.target.value) }} />
          </td>
        ) :
          (
            <td><span>{props.entry}</span></td>
          )
      }
      <RenderBasedOnEditable />
    </tr>
  )
}

export default ProfileAccountDetailRow;
