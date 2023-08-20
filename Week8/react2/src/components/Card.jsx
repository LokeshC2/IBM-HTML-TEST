import React from 'react'

export default function Card(props) {
  return (
    <div className="card border-primary m-2">
      <div className="card-body p-2 row">
        {props.children}
      </div>
    </div>
  )
}
